(ns kata-poker.hand-util
  (:gen-class)
  (:require [kata-poker.card-comparator :as cards]))

(defn highest-tuple-value
  [hand tuple]
  (first (last (filter #(= tuple (count (last %))) (group-by #((cards/card-to-value %) cards/card-order) hand)))))

(defn highest-dual-pair-values
  [hand]
  (let [pairs-combined
  (reduce concat
          (map last
               (filter #(= 2 (count (last %)))
                       (group-by #((cards/card-to-value %) cards/card-order) hand))))]
    (if (= (count pairs-combined) 4) pairs-combined '())))

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

(defn full-house?
  [hand]
  (let [values (map cards/card-to-value hand)]
    (= 5 (reduce + (filter #(or (= 3 %) (= 2 %)) (map last (frequencies values)))))))

(defn straight-flush?
 [hand]
  (and (flush? hand)
       (straight? hand)))
