(ns kata-poker.hand-comparator
  (:gen-class)
  (:require [kata-poker.card-comparator :as cards]
            [kata-poker.hand-util :refer :all]))

(defn by-high-card
  "Compares both hands regarding by who has got the higher card"
  [black white]
  (let [tuples (map vector (sort > (cons 0 (cards/hand-to-values black)))
                           (sort > (cons 0 (cards/hand-to-values white))))
        first-non-matching (first (drop-while #(= (first %) (second %)) tuples))]
     (compare (first  first-non-matching)
              (second first-non-matching))))

(defn by-pair
  "Compares both hands regarding by who has got the higher pair"
  [black white]
  (let [higher-value  (compare (highest-tuple-value black 2)
                               (highest-tuple-value white 2))]
    (if (not= 0 higher-value)
      higher-value)
      (by-high-card black white)))


(defn by-two-pairs
  "Compares both hands by the 'two pair' rule"
  [black white]
  (let [black-values (highest-dual-pair-values black)
        white-values (highest-dual-pair-values white)
        compare-result (by-high-card black-values white-values)]
      (if (not= 0 compare-result)
        compare-result
        (if (empty? black-values) 0 (by-high-card black white)))))


(defn by-triplet
  "Compares both hands regarding by who has got the higher triplet"
  [black white]
   (compare (highest-tuple-value black 3)
            (highest-tuple-value white 3)))

(defn by-straight
  "Compares both hands by the 'straight' rule"
  [black white]
  (let [black-straight? (straight? black)
        white-straight? (straight? white)]
    (if (and black-straight? white-straight?)
      (by-high-card black white)
      (if black-straight? 1 (if white-straight? -1 0)))))

(defn by-flush
  "Compares both hands by the 'flush' rule"
  [black white]
  (let [black-flush? (flush? black)
        white-flush? (flush? white)]
    (if (and black-flush? white-flush?)
      (by-high-card black white)
      (if black-flush? 1 (if white-flush? -1 0)))))

(defn by-full-house
  "Compares both hands by the 'full house' rule"
  [black white]
  (let [black-fh? (full-house? black)
        white-fh? (full-house? white)]
  (if (and black-fh? white-fh?)
    (by-triplet black white)
    (if black-fh? 1 (if white-fh? -1 0)))))

(defn by-quadruple
  "Compares both hands regarding by who has got the higher quadruple"
  [black white]
   (compare (highest-tuple-value black 4)
            (highest-tuple-value white 4)))

(defn by-straight-flush
  "Compares both hands by the 'straight flush' rule"
  [black white]
  (let [black-sf? (straight-flush? black)
        white-sf? (straight-flush? white)]
    (if (and black-sf? white-sf?)
      (by-high-card black white)
      (if black-sf? 1 (if white-sf? -1 0)))))

(defn compare-hands
  "Iterates through all defined rules until one hand wins one of them"
  [black white]
  (let [winner (first (drop-while #(= 0 %) (map #(% black white) [by-straight-flush
                             by-quadruple
                             by-full-house
                             by-flush
                             by-straight
                             by-triplet
                             by-two-pairs
                             by-pair
                             by-high-card])))]
    (if (nil? winner) 0 winner)))
