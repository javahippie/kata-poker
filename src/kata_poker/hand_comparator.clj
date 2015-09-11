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

(defn highest-pair-value
  [hand]
(first (last (filter #(= 2 (count (last %))) (group-by #((cards/card-to-value %) cards/card-order) hand)))))


(defn by-pair
  "Compares both hands regarding by who has got the higher pair"
  [black white]
  (let [black-is-pair (cards/pair? black)
        white-is-pair (cards/pair? white)
        higher-value  (compare (highest-pair-value black) (highest-pair-value white))]
    (if (not= 0 higher-value)
      higher-value)
      (by-high-card black white)))


(let [black '("AH" "AD" "5S" "9C" "KD")
          white '("AC" "AH" "4S" "8C" "AH")]
      (by-pair black white))
