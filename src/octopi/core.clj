(ns octopi.core
  (:require
    [honeysql.core :as sql]
    [honeysql.helpers :refer :all :as helpers]))

(defn -main [& args]
  (println "hey"))

(defn query-map []
 {:select [:uid :name]
  :from [:users]
  :where [:= :users.name "Barry"]})

(defn by-id []
  (merge-where (query-map) [:= :users.uid 5]))

(defn sub-query []
  {:select [:*]
   :from [(by-id) "sub"]})


(defn union-query []
  {:union-all [(query-map) (query-map)]})



