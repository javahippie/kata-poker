(ns kata-poker.hand-comparator
  (:gen-class)
  (:require [kata-poker.card-comparator :as cards]))

(defn by-high-card
  "Compares both hands regarding by who has got the higher card"
  [black white]
  (let [tuples (map vector (sort > (cons 0 (cards/hand-to-values black)))
                           (sort > (cons 0 (cards/hand-to-values white))))
        first-non-matching (first (drop-while #(= (first %) (second %)) tuples))]
     (compare (first  first-non-matching)
              (second first-non-matching))))

(defn highest-tuple-value
  [hand tuple]
  (first (last (filter #(= tuple (count (last %))) (group-by #((cards/card-to-value %) cards/card-order) hand)))))

(defn highest-dual-pair-values
  [hand]
  (reduce concat
          (map last
               (filter #(= 2 (count (last %)))
                       (group-by #((cards/card-to-value %) cards/card-order) hand)))))

(defn straight?
  [hand]
  (let [values (cards/hand-to-values hand)
        sorted-values (sort values)
        startval (first sorted-values)]
    (= sorted-values
       (range startval
              (+ startval 5)))))
(defn flush?
  [hand]
 (let [suits (map cards/card-to-suite hand)]
    (apply = suits)))

(defn by-pair
  "Compares both hands regarding by who has got the higher pair"
  [black white]
  (let [higher-value  (compare (highest-tuple-value black 2)
                               (highest-tuple-value white 2))]
    (if (not= 0 higher-value)
      higher-value)
      (by-high-card black white)))

(defn by-two-pairs
  [black white]
  (let [black-values (highest-dual-pair-values black)
        white-values (highest-dual-pair-values white)
        compare-result (by-high-card black-values white-values)]
      (if (not= 0 compare-result)
        compare-result
        (by-high-card black white))))

(defn by-triplet
  "Compares both hands regarding by who has got the higher triplet"
  [black white]
   (compare (highest-tuple-value black 3)
            (highest-tuple-value white 3)))

(defn by-straight
  [black white]
  (let [black-straight? (straight? black)
        white-straight? (straight? white)]
    (if (= black-straight? white-straight?)
      (by-high-card black white)
      (if black-straight? 1 -1))))

(defn by-flush
  [black white]
  (let [black-flush? (flush? black)
        white-flush? (flush? white)]
    (if (= black-flush? white-flush?)
      (by-high-card black white)
      (if black-flush? 1 -1))))

(defn by-full-house
  [black white]
  (let [black-fh? (cards/full-house? black)
        white-fh? (cards/full-house? white)]
  (if (= black-fh? white-fh?)
    (by-triplet black white)
    (if black-fh? 1 -1))))

(defn by-quadruple
  "Compares both hands regarding by who has got the higher quadruple"
  [black white]
   (compare (highest-tuple-value black 4)
            (highest-tuple-value white 4)))
