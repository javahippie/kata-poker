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


(defn compare-hands
  [black white])

    (let [black '("2H" "3D" "5S" "9C" "KD")
          white '("2C" "3H" "4S" "8C" "AH")]
(by-high-card black white))


