; Thanks to https://github.com/korma/Korma
(ns cljminders.db.connection)
(use 'korma.db)
(use 'korma.core)

(declare reminders)

(defdb db (sqlite3 {:db ".cljminders.db"}))

(defentity reminders
    (table :reminders)
    (database db)
    (entity-fields :id :description :time)
)

(def createReminders (str "
                          CREATE TABLE IF NOT EXISTS reminders
                          ( 
                            id int,
                            description text,
                            time timestamp
                          );
                          "))

(exec-raw createReminders)
