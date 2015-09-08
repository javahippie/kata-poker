(ns kata-poker.core
  (:gen-class))

(def card-order {:2 0
                 :3 1
                 :4 2
                 :5 3
                 :6 4
                 :7 5
                 :8 6
                 :9 7
                 :T 8
                 :J 9
                 :Q 10
                 :K 11
                 :A 12})

(def hand-order {:high-card 0
                 :pair 1
                 :two-pairs 2
                 :three-of-a-kind 3
                 :straight 4
                 :flush 5
                 :full-house 6
                 :four-of-a-kind 7
                 :straight-flush 8})

(defn card-to-value
  [card]
  (keyword (subs card 0 1)))

(defn card-to-suite
  [card]
  (subs card 1 2))

(defn higher-card
  "Returns negative value if the second card is higher, 0 when they are equal and positive value if the first card is higher."
  [card-1 card-2]
  (let [value-1 ((card-to-value card-1) card-order)
        value-2 ((card-to-value card-2) card-order)]
    (compare value-1 value-2)))

(defn pair?
  [hand]
  (let [values (map card-to-value hand)]
    (not (empty? (filter #(< 1 (last %)) (frequencies values))))))

(defn two-pairs?
  [hand]
  )

(defn three-of-a-kind?
  [hand]
  )

(defn straight?
  [hand]
  )

(defn flush?
  [hand]
  true)

(defn full-house?
  [hand]
  )

(defn four-of-a-kind?
  [hand]
  )

(defn straight-flush?
 [hand]
  (let [values (map card-to-value hand)
        suits (map card-to-suite hand)]
  (and (flush? hand) (apply = suits))))


