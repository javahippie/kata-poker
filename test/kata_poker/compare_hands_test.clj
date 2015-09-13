(ns kata-poker.compare-hands-test
  (:require [clojure.test :refer :all]
            [kata-poker.hand-comparator :refer :all]))

(deftest test-compare-hands-by-high-card-black-wins
  (testing "Comparing two single hands, first hand smaller"
    (let [black '("3S" "4A" "8E" "9D" "AD")
          white '("3A" "4S" "9D" "TA" "KF")
          result (compare-hands black white)]
    (is (pos? result)))))

(deftest test-compare-hands-by-high-card-white-wins
  (testing "Comparing two single hands, first hand smaller"
    (let [black '("3S" "4A" "8E" "9D" "AD")
          white '("3A" "4S" "9D" "TA" "AF")
          result (compare-hands black white)]
    (is (neg? result)))))

(deftest test-compare-hands-tie
  (testing "Comparing two single hands, hands tie"
    (let [black '("3S" "4A" "8E" "9D" "AD")
          white '("3A" "4S" "8D" "9A" "AF")
          result (compare-hands black white)]
    (is (zero? result)))))

