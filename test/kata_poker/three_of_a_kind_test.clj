(ns kata-poker.three-of-a-kind-test
  (:require [clojure.test :refer :all]
            [kata-poker.core :refer :all]))

(deftest test-three-of-a-kind-correct
  (testing "Checking, if a hand contais a triplet"
    (let [hand '("2E" "2D" "2S" "4E" "5S")
          result (three-of-a-kind? hand)]
    (is result))))

(deftest test-three-of-a-kind-correct-with-triple
  (testing "Checking, if a hand contais a triplet whit the 'triplet' really being a quadruple"
    (let [hand '("2E" "2D" "2S" "2E" "2S")
          result (three-of-a-kind? hand)]
    (is result))))

(deftest test-three-of-a-kind-correct-non-consecutive
  (testing "Checking, if a hand contais a pair with the pair not being consecutive"
    (let [hand '("2E" "1D" "2D" "4E" "2S")
          result (three-of-a-kind? hand)]
    (is result))))

(deftest test-three-of-a-kind-incorrect
  (testing "Checking, if a hand contais a pair with a hand that should fail"
    (let [hand '("2E" "1D" "2S" "4E" "TS")
          result (three-of-a-kind? hand)]
    (is (not result)))))
