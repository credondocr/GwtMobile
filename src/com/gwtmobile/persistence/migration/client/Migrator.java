package com.gwtmobile.persistence.migration.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Created by IntelliJ IDEA.
 * User: robert
 * Date: 7/26/11
 * Time: 1:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class Migrator  {

    public interface Migration{
        JavaScriptObject getMigration();
    }

    public interface MigrationCallback{
        void onSuccess();
    }

    private JavaScriptObject persistence;

    public Migrator(){
        persistence = getPersistence();
    }

    public void init(MigrationCallback callback){
        init(persistence, callback);
    }

    private native JavaScriptObject getPersistence()/*-{
        return $wnd.persistence;
    }-*/;


    private native void init(JavaScriptObject persistence, MigrationCallback callback)/*-{
        persistence.migrations.init(
                function(){
                    callback.@com.gwtmobile.persistence.migration.client.Migrator.MigrationCallback::onSuccess()();

                }
        );
    }-*/;

    public void defineMigration(int version, Migration migration){
        defineMigration(persistence, version, migration.getMigration());
    }

    public void migrate(){
        migrate(persistence);
    }

    public void migrate(MigrationCallback callback){
        migrate(persistence, callback);
    }

    public void migrate(int version, MigrationCallback callback){
        migrate(persistence, version, callback);

    }

    private native void defineMigration(JavaScriptObject persistence, int version, JavaScriptObject migration)/*-{
        persistence.defineMigration(version, migration);
    }-*/;

    private native void migrate(JavaScriptObject persistence)/*-{
        persistence.migrate();
    }-*/;

    private native void migrate(JavaScriptObject persistence, MigrationCallback callback)/*-{
        persistence.migrate(
                function(){
                    callback.@com.gwtmobile.persistence.migration.client.Migrator.MigrationCallback::onSuccess()();
                }
        );
    }-*/;

    private native void migrate(JavaScriptObject persistence, int version, MigrationCallback callback)/*-{
        persistence.migrate(version,
                function(){
                    callback.@com.gwtmobile.persistence.migration.client.Migrator.MigrationCallback::onSuccess()();
                }
        );
    }-*/;
}
