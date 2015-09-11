(ns kata-poker.pair-test
  (:require [clojure.test :refer :all]
            [kata-poker.card-comparator :refer :all]))

(deftest test-pair-correct
  (testing "Checking, if a hand contais a pair"
    (let [hand '("2E" "2D" "3S" "4E" "5S")
          result (pair? hand)]
    (is result))))

(deftest test-pair-correct-with-triple
  (testing "Checking, if a hand contais a pair with the 'pair' really being a triplet"
    (let [hand '("2E" "2D" "3S" "4E" "2S")
          result (pair? hand)]
    (is (not result)))))

(deftest test-pair-correct-non-consecutive
  (testing "Checking, if a hand contais a pair with the pair not being consecutive"
    (let [hand '("2E" "1D" "3S" "4E" "2S")
          result (pair? hand)]
    (is result))))

(deftest test-pair-incorrect
  (testing "Checking, if a hand contais a pair with a hand that should fail"
    (let [hand '("2E" "1D" "3S" "4E" "TS")
          result (pair? hand)]
    (is (not result)))))
