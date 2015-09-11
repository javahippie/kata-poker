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

(defn by-quadruple
  "Compares both hands regarding by who has got the higher quadruple"
  [black white]
   (compare (highest-tuple-value black 4)
            (highest-tuple-value white 4)))
