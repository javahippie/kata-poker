(ns kata-poker.flush-test
  (:require [clojure.test :refer :all]
            [kata-poker.core :refer :all]))

(deftest test-flush-correct
  (testing "Checking, if a hand contais a flush"
    (let [hand '("2E" "3E" "4E" "5E" "6E")
          result (flush? hand)]
    (is result))))

(deftest test-flush-notnumeric
  (testing "Checking, if a hand contais a flush with not numeric cards"
    (let [hand '("TE" "JE" "QE" "KE" "AE")
          result (flush? hand)]
    (is result))))

(deftest test-flush-incorrect
  (testing "Checking, if a hand contais a flush with not numeric cards"
    (let [hand '("TE" "JE" "JS" "KE" "AE")
          result (flush? hand)]
    (is (not result)))))
