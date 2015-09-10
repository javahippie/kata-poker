(ns kata-poker.hands-higher-card-test
  (:require [clojure.test :refer :all]
            [kata-poker.hand-comparator :refer :all]))

(deftest test-higher-cards-black-wins
  (testing "Comparing two hands by higher card"
    (let [black '("2H" "3D" "5S" "9C" "KD")
          white '("2C" "3H" "4S" "8C" "KH")
          result (by-high-card black white)]
    (is (pos? result)))))

(deftest test-higher-cards-white-wins
  (testing "Comparing two hands by higher card"
    (let [black '("2H" "3D" "5S" "9C" "KD")
          white '("2C" "3H" "4S" "8C" "AH")
          result (by-high-card black white)]
    (is (neg? result)))))
