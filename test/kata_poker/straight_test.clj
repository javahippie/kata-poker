(ns kata-poker.straight-test
  (:require [clojure.test :refer :all]
            [kata-poker.card-comparator :refer :all]))

(deftest test-straight-correct
  (testing "Checking, if a hand contais a straight"
    (let [hand '("2E" "3D" "4S" "5E" "6S")
          result (straight? hand)]
    (is result))))

(deftest test-straight-notnumeric
  (testing "Checking, if a hand contais a straight with not numeric cards"
    (let [hand '("TE" "JD" "QS" "KE" "AS")
          result (straight? hand)]
    (is result))))

(deftest test-straight-incorrect
  (testing "Checking, if a hand contais a straight with not numeric cards"
    (let [hand '("TE" "JD" "JS" "KE" "AS")
          result (straight? hand)]
    (is (not result)))))
