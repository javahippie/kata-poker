(ns kata-poker.core
  (:gen-class)
  (:require [kata-poker.hand-comparator :as hands]))

(defn prompt-and-read
  [prompt]
  (println prompt)
  (read-line))

(defn entry-to-hand
  [entry]
  (seq (.split entry " ")))

(defn -main [& args]
  (println "This is tool for comparing poker hands.")
  (let [black (entry-to-hand (prompt-and-read "Please enter the black hand"))
        white (entry-to-hand (prompt-and-read "Please enter the white hand"))
        result (hands/compare-hands black white)]
    (if (zero? result)
      (println "Tie!")
      (if (pos? result)
        (println "Black wins!")
        (println "White wins!")))))

