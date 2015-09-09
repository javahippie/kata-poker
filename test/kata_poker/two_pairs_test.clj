(ns kata-poker.two-pairs-test
  (:require [clojure.test :refer :all]
            [kata-poker.core :refer :all]))

(deftest test-two-pairs-correct
  (testing "Checking, if a hand contais two pairs"
    (let [hand '("2E" "2D" "3S" "4E" "3S")
          result (two-pairs? hand)]
    (is result))))

(deftest test-two-pairs-correct-with-triple
  (testing "Checking, if a hand contais two pairs with one 'pair' being a triplet"
    (let [hand '("2E" "2D" "4S" "4E" "4D")
          result (two-pairs? hand)]
    (is result))))

(deftest test-two-pairs-incorrect
  (testing "Checking, if a hand contais two pairs with a hand that should fail"
    (let [hand '("2E" "1D" "3S" "2E" "2S")
          result (two-pairs? hand)]
    (is (not result)))))
