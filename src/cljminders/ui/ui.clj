(ns cljminders.ui.ui
  (:require [cljminders.db.operations :as operations])
  (:gen-class))

(defn runOperationBasedOnInput [input] 
	(case input
		"1" (println "create")
		"2" (println "read")
		"3" (println "update")
		(println "delete")
	)
)

(defn prompt [] 
	(println "What would you like to do?")
	(println "1. Create new reminder")
	(println "2. Show all reminders")
	(println "3. Update existing reminder")
	(println "4. Delete reminder")
	(runOperationBasedOnInput (read-line))
)
