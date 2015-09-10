(ns kata-poker.full-house-test
  (:require [clojure.test :refer :all]
            [kata-poker.card-comparator :refer :all]))

(deftest test-full-house-correct
  (testing "Checking, if a hand contais a triplet"
    (let [hand '("2E" "2D" "2S" "4E" "4S")
          result (full-house? hand)]
    (is result))))

(deftest test-full-house-incorrect
  (testing "Checking, if a hand contais a pair with a hand that should fail"
    (let [hand '("2E" "2D" "2S" "4E" "TS")
          result (full-house? hand)]
    (is (not result)))))
