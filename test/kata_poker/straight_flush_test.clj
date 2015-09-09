(ns kata-poker.straight-flush-test
  (:require [clojure.test :refer :all]
            [kata-poker.core :refer :all]))

(deftest test-straight-flush-correct
  (testing "Checking, if a hand contais a straight-flush"
    (let [hand '("2E" "3E" "4E" "5E" "6E")
          result (straight-flush? hand)]
    (is result))))

(deftest test-straight-flush-notnumeric
  (testing "Checking, if a hand contais a straight-flush with not numeric cards"
    (let [hand '("TE" "JE" "QE" "KE" "AE")
          result (straight-flush? hand)]
    (is result))))

(deftest test-straight-flush-incorrect-values
  (testing "Checking, if a hand contais a straight-flush with not numeric cards"
    (let [hand '("TE" "JE" "2E" "KE" "AE")
          result (straight-flush? hand)]
    (is (not result)))))

(deftest test-straight-flush-incorrect-suit
  (testing "Checking, if a hand contais a straight-flush with not numeric cards"
    (let [hand '("TE" "JE" "QS" "KE" "AE")
          result (straight-flush? hand)]
    (is (not result)))))
