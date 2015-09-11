(ns kata-poker.hands-higher-full-house-test
  (:require [clojure.test :refer :all]
            [kata-poker.hand-comparator :refer :all]))

(deftest test-higher-full-house-black-wins
  (testing "Comparing two hands by higher card"
    (let [black '("2H" "2H" "4H" "4H" "4H")
          white '("2C" "3H" "4S" "8C" "KH")
          result (by-full-house black white)]
    (is (pos? result)))))

(deftest test-higher-full-house-white-wins
  (testing "Comparing two hands by higher card"
    (let [black '("3H" "3H" "4H" "4H" "4H")
          white '("3H" "3H" "5H" "5H" "5H")
          result (by-full-house black white)]
    (is (neg? result)))))

(deftest test-higher-full-house-tie
  (testing "Comparing two hands by higher card"
    (let [black '("3H" "3H" "4H" "4H" "4H")
          white '("3D" "3D" "4D" "4D" "4D")
          result (by-full-house black white)]
    (is (zero? result)))))


