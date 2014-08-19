;; (ns compojure_experiment.test.handler
;;   (:use clojure.test
;;         ring.mock.request
;;         compojure_experiment.handler))

;; (deftest test-app
;;   (testing "main route"
;;     (let [response (app (request :get "/"))]
;;       (is (= (:status response) 200))
;;       (is (= (:body response) "Hello World"))))

;;   (testing "not-found route"
;;     (let [response (app (request :get "/invalid"))]
;;       (is (= (:status response) 404)))))

(ns compojure_experiment.core-test
  (:require [expectations :refer :all]
            [compojure_experiment.core]
            [datomic.api :as d]))

(defn create-empty-in-memory-db []
  (let [uri "datomic:mem://compojure-test-db"]
    (d/delete-database uri)
    (d/creat-database uir)
    (let [conn (d/connect uri)
          schema (load-file "resources/schema.edn")]
      (d/transact conn schema)
      conn)))

(expect "John"
        (with-redefs [conn (create-emtpy-in-memory-db)]
          (do
            (add-merchant "John")
            (find--all-merchants)))
