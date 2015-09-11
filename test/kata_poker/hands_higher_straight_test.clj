(ns kata-poker.hands-higher-straight-test
  (:require [clojure.test :refer :all]
            [kata-poker.hand-comparator :refer :all]))

(deftest test-higher-straight-black-wins
  (testing "Comparing two hands by higher card"
    (let [black '("2H" "3D" "4S" "5C" "6D")
          white '("2C" "3H" "4S" "8C" "KH")
          result (by-straight black white)]
    (is (pos? result)))))

(deftest test-higher-straight-white-wins
  (testing "Comparing two hands by higher card"
    (let [black '("2H" "3D" "4S" "5C" "6D")
          white '("3C" "4H" "5S" "6C" "7H")
          result (by-straight black white)]
    (is (neg? result)))))

(deftest test-higher-straight-tie
  (testing "Comparing two hands by higher card"
    (let [black '("2H" "3D" "4S" "5C" "6D")
          white '("2D" "3H" "4C" "5S" "6H")
          result (by-straight black white)]
    (is (zero? result)))))


