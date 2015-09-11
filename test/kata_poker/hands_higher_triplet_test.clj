(ns kata-poker.hands-higher-triplet-test
  (:require [clojure.test :refer :all]
            [kata-poker.hand-comparator :refer :all]))

(deftest test-higher-triplets-black-wins
  (testing "Comparing two hands by higher card"
    (let [black '("2H" "2D" "2S" "9C" "KD")
          white '("3C" "3H" "4S" "8C" "KH")
          result (by-triplet black white)]
    (is (pos? result)))))

(deftest test-higher-triplets-white-wins
  (testing "Comparing two hands by higher card"
    (let [black '("2H" "2D" "5S" "2C" "KD")
          white '("2C" "4H" "4S" "4C" "AH")
          result (by-triplet black white)]
    (is (neg? result)))))
