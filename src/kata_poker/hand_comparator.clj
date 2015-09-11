(ns kata-poker.hand-comparator
  (:gen-class)
  (:require [kata-poker.card-comparator :as cards]))

(defn by-high-card
  "Compares both hands regarding by who has got the higher card"
  [black white]
  (let [tuples (map vector (sort > (cards/hand-to-values black)) (sort > (cards/hand-to-values white)))
        first-non-matching (first (drop-while #(= (first %) (second %)) tuples))]
     (compare (first first-non-matching)
              (second first-non-matching))))

(defn highest-tuple-value
  [hand tuple]
(first (last (filter #(= tuple (count (last %))) (group-by #((cards/card-to-value %) cards/card-order) hand)))))


(defn by-pair
  "Compares both hands regarding by who has got the higher pair"
  [black white]
  (let [higher-value  (compare (highest-tuple-value black 2)
                               (highest-tuple-value white 2))]
    (if (not= 0 higher-value)
      higher-value)
      (by-high-card black white)))

(defn by-triplet
  "Compares both hands regarding by who has got the higher pair"
  [black white]
   (compare (highest-tuple-value black 3)
            (highest-tuple-value white 3)))

(defn by-quadruple
  "Compares both hands regarding by who has got the higher pair"
  [black white]
   (compare (highest-tuple-value black 4)
            (highest-tuple-value white 4)))

(let [black '("AH" "AD" "5S" "9C" "KD")
          white '("AC" "AH" "4S" "8C" "AH")]
      (by-pair black white))
