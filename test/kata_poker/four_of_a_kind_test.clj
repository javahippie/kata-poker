(ns kata-poker.four-of-a-kind-test
  (:require [clojure.test :refer :all]
            [kata-poker.card-comparator :refer :all]))

(deftest test-four-of-a-kind-correct
  (testing "Checking, if a hand contais a quadruple"
    (let [hand '("2E" "2D" "2S" "2E" "5S")
          result (four-of-a-kind? hand)]
    (is result))))

(deftest test-four-of-a-kind-correct-non-consecutive
  (testing "Checking, if a hand contais a quadruple with the quadruple not being consecutive"
    (let [hand '("2E" "1D" "2D" "2E" "2S")
          result (four-of-a-kind? hand)]
    (is result))))

(deftest test-four-of-a-kind-incorrect
  (testing "Checking, if a hand contais a quadruple with a hand that should fail"
    (let [hand '("2E" "1D" "2S" "2E" "TS")
          result (four-of-a-kind? hand)]
    (is (not result)))))
