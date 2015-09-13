(ns kata-poker.hands-higher-two-pair-test
  (:require [clojure.test :refer :all]
            [kata-poker.hand-comparator :refer :all]))

(deftest test-higher-two-pairs-black-wins
  (testing "Comparing two hands by higher card"
    (let [black '("2H" "2D" "3S" "3C" "KD")
          white '("2C" "3H" "4S" "8C" "KH")
          result (by-two-pairs black white)]
    (is (pos? result)))))

(deftest test-higher-two-pairs-white-wins
  (testing "Comparing two hands by higher card"
    (let [black '("2H" "2D" "4S" "4C" "KD")
          white '("3C" "3H" "4S" "4C" "AH")
          result (by-two-pairs black white)]
    (is (neg? result)))))

(deftest test-higher-two-pairs-black-wins-by-higher-card
  (testing "Comparing two hands by higher card"
    (let [black '("2H" "2D" "5S" "5C" "AD")
          white '("2C" "2H" "5S" "5C" "KH")
          result (by-two-pairs black white)]
    (is (pos? result)))))

(deftest test-higher-two-pairs-white-wins-by-higher-card
  (testing "Comparing two hands by higher card"
    (let [black '("2H" "2D" "5S" "5C" "KD")
          white '("2C" "2H" "5S" "5C" "AH")
          result (by-two-pairs black white)]
    (is (neg? result)))))

(deftest test-higher-two-pairs-tie
  (testing "Comparing two hands by higher card"
    (let [black '("2H" "2D" "9S" "9C" "KD")
          white '("2D" "2H" "9C" "9S" "KH")
          result (by-two-pairs black white)]
    (is (zero? result)))))

(deftest test-higher-two-pairs-tie-single-pair
  (testing "Comparing two hands by higher card"
    (let [black '("2H" "3D" "9S" "9C" "KD")
          white '("2D" "3H" "8C" "8S" "KH")
          result (by-two-pairs black white)]
    (is (zero? result)))))


