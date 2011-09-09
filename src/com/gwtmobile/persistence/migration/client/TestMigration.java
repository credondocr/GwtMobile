package com.gwtmobile.persistence.migration.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Created by IntelliJ IDEA.
 * User: robert
 * Date: 7/26/11
 * Time: 11:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestMigration {

    public void test(){
        Migrator migrator = new Migrator();

        migrator.defineMigration(1, new Migrator.Migration() {
            public native JavaScriptObject getMigration()/*-{
                return {
                    up: function(){
                        this.createTable('Test', function(t){
                                    t.text('name');
                                    t.text('description');
                                }
                        );
                    },
                    down: function(){
                        this.dropTable('Test');
                    }
                }
            }-*/;
        });
    }
}
