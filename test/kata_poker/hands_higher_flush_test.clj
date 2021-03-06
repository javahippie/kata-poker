(ns kata-poker.hands-higher-flush-test
  (:require [clojure.test :refer :all]
            [kata-poker.hand-comparator :refer :all]))

(deftest test-higher-flush-black-wins
  (testing "Comparing two hands by higher card"
    (let [black '("2H" "3H" "4H" "5H" "6H")
          white '("2C" "3H" "4S" "8C" "KH")
          result (by-flush black white)]
    (is (pos? result)))))

(deftest test-higher-flush-white-wins
  (testing "Comparing two hands by higher card"
    (let [black '("2H" "3H" "4H" "5H" "6H")
          white '("3H" "4H" "5H" "6H" "7H")
          result (by-flush black white)]
    (is (neg? result)))))

(deftest test-higher-flush-tie
  (testing "Comparing two hands by higher card"
    (let [black '("2H" "3H" "4H" "5H" "6H")
          white '("2D" "3D" "4D" "5D" "6D")
          result (by-flush black white)]
    (is (zero? result)))))


