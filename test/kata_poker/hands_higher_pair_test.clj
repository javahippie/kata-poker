(ns kata-poker.hands-higher-pair-test
  (:require [clojure.test :refer :all]
            [kata-poker.hand-comparator :refer :all]))

(deftest test-higher-pairs-black-wins
  (testing "Comparing two hands by higher card"
    (let [black '("2H" "2D" "5S" "9C" "KD")
          white '("2C" "3H" "4S" "8C" "KH")
          result (by-pair black white)]
    (is (pos? result)))))

(deftest test-higher-pairs-white-wins
  (testing "Comparing two hands by higher card"
    (let [black '("2H" "2D" "5S" "9C" "KD")
          white '("2C" "4H" "4S" "8C" "AH")
          result (by-pair black white)]
    (is (neg? result)))))

(deftest test-higher-pairs-black-wins-by-higher-card
  (testing "Comparing two hands by higher card"
    (let [black '("2H" "2D" "5S" "9C" "KD")
          white '("2C" "2H" "4S" "8C" "KH")
          result (by-pair black white)]
    (is (pos? result)))))

(deftest test-higher-pairs-white-wins-by-higher-card
  (testing "Comparing two hands by higher card"
    (let [black '("2H" "5D" "5S" "9C" "KD")
          white '("2C" "5H" "5S" "8C" "AH")
          result (by-pair black white)]
    (is (neg? result)))))

(deftest test-higher-pairs-tie
  (testing "Comparing two hands by higher card"
    (let [black '("2H" "3D" "5S" "9C" "KD")
          white '("2D" "3H" "5C" "9S" "KH")
          result (by-pair black white)]
    (is (zero? result)))))


