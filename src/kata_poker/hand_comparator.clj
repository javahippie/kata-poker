(ns kata-poker.hand-comparator
  (:gen-class)
  (:require [kata-poker.card-comparator :as cards]))

(defn- by-high-card
  [black white]
  (let [values-black (cards/hand-to-values black)
        values-white (cards/hand-to-values white)]
    '(values-black values-white)))


(defn compare-hands
  [black white])


(by-high-card '("2H" "3D" "5S" "9C" "KD")
               '("2C" "3H" "4S" "8C" "AH"))

