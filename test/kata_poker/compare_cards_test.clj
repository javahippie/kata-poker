(ns kata-poker.compare-cards-test
  (:require [clojure.test :refer :all]
            [kata-poker.card-comparator :refer :all]))

(deftest test-compare-cards-1
  (testing "Comparing two single cards, first card smaller"
    (let [card-1 "2S"
          card-2 "3D"
          result (compare-cards card-1 card-2)]
    (is (neg? result)))))

(deftest test-compare-cards-2
  (testing "Comparing two single cards, first card higher"
    (let [card-1 "8S"
          card-2 "3D"
          result (compare-cards card-1 card-2)]
    (is (pos? result)))))


(deftest test-compare-cards-3
  (testing "Comparing two single cards, cards equal"
    (let [card-1 "2S"
          card-2 "2S"
          result (compare-cards card-1 card-2)]
    (is (= result 0)))))
