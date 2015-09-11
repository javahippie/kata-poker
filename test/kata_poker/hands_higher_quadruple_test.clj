(ns kata-poker.hands-higher-quadruple-test
  (:require [clojure.test :refer :all]
            [kata-poker.hand-comparator :refer :all]))

(deftest test-higher-quadruples-black-wins
  (testing "Comparing two hands by higher card"
    (let [black '("2H" "2D" "2S" "2C" "KD")
          white '("3C" "3H" "3S" "8C" "KH")
          result (by-quadruple black white)]
    (is (pos? result)))))

(deftest test-higher-quadruples-white-wins
  (testing "Comparing two hands by higher card"
    (let [black '("2H" "2D" "5S" "2C" "2D")
          white '("1C" "4H" "4S" "4C" "4H")
          result (by-quadruple black white)]
    (is (neg? result)))))
