(ns kata-poker.hand-comparator
  (:gen-class)
  (:require [kata-poker.card-comparator :as cards]))

(defn- by-high-card
  "Compares both hands regarding by who has got the higher card"
  [black white]
  (let [tuples (map vector (sort > (cards/hand-to-values black)) (sort > (cards/hand-to-values white)))
        first-non-matching (take 1 (drop-while #(= (first %) (second %)) tuples))]
     (compare (first first-non-matching)
              (second first-non-matching))))


(defn compare-hands
  [black white])


(by-high-card '("2H" "3D" "4S" "8C" "AD")
               '("2C" "3H" "4S" "7C" "AH"))


