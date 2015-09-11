(ns kata-poker.card-comparator
  (:gen-class))

(def card-order {:2 1
                 :3 2
                 :4 3
                 :5 4
                 :6 5
                 :7 6
                 :8 7
                 :9 8
                 :T 9
                 :J 10
                 :Q 11
                 :K 12
                 :A 13})

(def hand-order {:high-card 1000
                 :pair 2000
                 :two-pairs 3000
                 :three-of-a-kind 4000
                 :straight 5000
                 :flush 6000
                 :full-house 7000
                 :four-of-a-kind 8000
                 :straight-flush 9000})

(defn card-to-value
  [card]
  (keyword (subs card 0 1)))

(defn card-to-suite
  [card]
  (subs card 1 2))

(defn hand-to-values
  [hand]
  (map #((card-to-value %) card-order) hand))

(defn compare-cards
  "Returns negative value if the second card is higher, 0 when they are equal and positive value if the first card is higher."
  [card-1 card-2]
  (let [value-1 ((card-to-value card-1) card-order)
        value-2 ((card-to-value card-2) card-order)]
    (compare value-1 value-2)))

(defn two-pairs?
  [hand]
 (let [values (map card-to-value hand)]
    (< 1 (count (filter #(< 1 (last %)) (frequencies values))))))

(defn straight?
  [hand]
  (let [values (hand-to-values hand)
        sorted-values (sort values)
        startval (first sorted-values)]
    (= sorted-values
       (range startval
              (+ startval 5)))))

(defn flush?
  [hand]
 (let [suits (map card-to-suite hand)]
    (apply = suits)))

(defn full-house?
  [hand]
  (let [values (map card-to-value hand)]
    (= 5 (reduce + (filter #(or (= 3 %) (= 2 %)) (map last (frequencies values)))))))

(defn straight-flush?
 [hand]
  (and (flush? hand)
       (straight? hand)))
