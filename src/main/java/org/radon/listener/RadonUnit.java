
package org.radon.listener;

import java.util.HashSet;
import java.util.Set;

import org.drools.ruleunits.api.DataSource;
import org.drools.ruleunits.api.DataStore;
import org.drools.ruleunits.api.RuleUnitData;
import org.radon.listener.facts.CreateRequestCollection;
import org.radon.listener.facts.CreateRequestGroup;
import org.radon.listener.facts.CreateRequestResource;
import org.radon.listener.facts.CreateRequestUser;
import org.radon.listener.facts.CreateSuccessCollection;
import org.radon.listener.facts.CreateSuccessGroup;
import org.radon.listener.facts.DeleteRequestCollection;
import org.radon.listener.facts.DeleteRequestGroup;
import org.radon.listener.facts.DeleteRequestResource;
import org.radon.listener.facts.DeleteRequestUser;
import org.radon.listener.facts.DeleteSuccessCollection;
import org.radon.listener.facts.DeleteSuccessGroup;
import org.radon.listener.facts.DeleteSuccessResource;
import org.radon.listener.facts.CreateSuccessUser;
import org.radon.listener.facts.DeleteFailCollection;
import org.radon.listener.facts.DeleteFailGroup;
import org.radon.listener.facts.DeleteFailResource;
import org.radon.listener.facts.DeleteFailUser;
import org.radon.listener.facts.CreateSuccessResource;
import org.radon.listener.facts.CreateFailCollection;
import org.radon.listener.facts.CreateFailGroup;
import org.radon.listener.facts.CreateFailResource;
import org.radon.listener.facts.CreateFailUser;
import org.radon.listener.facts.DeleteSuccessUser;
import org.radon.listener.facts.UpdateFailCollection;
import org.radon.listener.facts.UpdateFailGroup;
import org.radon.listener.facts.UpdateFailResource;
import org.radon.listener.facts.UpdateFailUser;
import org.radon.listener.facts.UpdateRequestCollection;
import org.radon.listener.facts.UpdateRequestGroup;
import org.radon.listener.facts.UpdateRequestResource;
import org.radon.listener.facts.UpdateRequestUser;
import org.radon.listener.facts.UpdateSuccessCollection;
import org.radon.listener.facts.UpdateSuccessGroup;
import org.radon.listener.facts.UpdateSuccessResource;
import org.radon.listener.facts.UpdateSuccessUser;

public class RadonUnit implements RuleUnitData {

    private final DataStore<CreateRequestCollection> createRequestCollection;
    private final DataStore<CreateSuccessCollection> createSuccessCollection;
    private final DataStore<CreateFailCollection> createFailCollection;
    private final DataStore<CreateRequestUser> createRequestUser;
    private final DataStore<CreateSuccessUser> createSuccessUser;
    private final DataStore<CreateFailUser> createFailUser;
    private final DataStore<CreateRequestResource> createRequestResource;
    private final DataStore<CreateSuccessResource> createSuccessResource;
    private final DataStore<CreateFailResource> createFailResource;
    private final DataStore<CreateRequestGroup> createRequestGroup;
    private final DataStore<CreateSuccessGroup> createSuccessGroup;
    private final DataStore<CreateFailGroup> createFailGroup;

    private final DataStore<DeleteRequestCollection> deleteRequestCollection;
    private final DataStore<DeleteSuccessCollection> deleteSuccessCollection;
    private final DataStore<DeleteFailCollection> deleteFailCollection;
    private final DataStore<DeleteRequestUser> deleteRequestUser;
    private final DataStore<DeleteSuccessUser> deleteSuccessUser;
    private final DataStore<DeleteFailUser> deleteFailUser;
    private final DataStore<DeleteRequestResource> deleteRequestResource;
    private final DataStore<DeleteSuccessResource> deleteSuccessResource;
    private final DataStore<DeleteFailResource> deleteFailResource;
    private final DataStore<DeleteRequestGroup> deleteRequestGroup;
    private final DataStore<DeleteSuccessGroup> deleteSuccessGroup;
    private final DataStore<DeleteFailGroup> deleteFailGroup;

    private final DataStore<UpdateRequestCollection> updateRequestCollection;
    private final DataStore<UpdateSuccessCollection> updateSuccessCollection;
    private final DataStore<UpdateFailCollection> updateFailCollection;
    private final DataStore<UpdateRequestUser> updateRequestUser;
    private final DataStore<UpdateSuccessUser> updateSuccessUser;
    private final DataStore<UpdateFailUser> updateFailUser;
    private final DataStore<UpdateRequestResource> updateRequestResource;
    private final DataStore<UpdateSuccessResource> updateSuccessResource;
    private final DataStore<UpdateFailResource> updateFailResource;
    private final DataStore<UpdateRequestGroup> updateRequestGroup;
    private final DataStore<UpdateSuccessGroup> updateSuccessGroup;
    private final DataStore<UpdateFailGroup> updateFailGroup;
    
    
    
    
    private final Set<String> controlSet = new HashSet<>();

    public RadonUnit() {
    	createRequestCollection = DataSource.createStore();
        createSuccessCollection = DataSource.createStore();
        createFailCollection = DataSource.createStore();
        createRequestUser = DataSource.createStore();
        createSuccessUser = DataSource.createStore();
        createFailUser = DataSource.createStore();
        createRequestResource = DataSource.createStore();
        createSuccessResource = DataSource.createStore();
        createFailResource = DataSource.createStore();
        createRequestGroup = DataSource.createStore();
        createSuccessGroup = DataSource.createStore();
        createFailGroup = DataSource.createStore();

        deleteRequestCollection = DataSource.createStore();
        deleteSuccessCollection = DataSource.createStore();
        deleteFailCollection = DataSource.createStore();
        deleteRequestUser = DataSource.createStore();
        deleteSuccessUser = DataSource.createStore();
        deleteFailUser = DataSource.createStore();
        deleteRequestResource = DataSource.createStore();
        deleteSuccessResource = DataSource.createStore();
        deleteFailResource = DataSource.createStore();
        deleteRequestGroup = DataSource.createStore();
        deleteSuccessGroup = DataSource.createStore();
        deleteFailGroup = DataSource.createStore();

        updateRequestCollection = DataSource.createStore();
        updateSuccessCollection = DataSource.createStore();
        updateFailCollection = DataSource.createStore();
        updateRequestUser = DataSource.createStore();
        updateSuccessUser = DataSource.createStore();
        updateFailUser = DataSource.createStore();
        updateRequestResource = DataSource.createStore();
        updateSuccessResource = DataSource.createStore();
        updateFailResource = DataSource.createStore();
        updateRequestGroup = DataSource.createStore();
        updateSuccessGroup = DataSource.createStore();
        updateFailGroup = DataSource.createStore();

    }



    public DataStore<CreateRequestCollection> getCreateRequestCollection() {
		return createRequestCollection;
	}



	public DataStore<CreateSuccessCollection> getCreateSuccessCollection() {
		return createSuccessCollection;
	}



	public DataStore<CreateFailCollection> getCreateFailCollection() {
		return createFailCollection;
	}



	public DataStore<CreateRequestUser> getCreateRequestUser() {
		return createRequestUser;
	}



	public DataStore<CreateSuccessUser> getCreateSuccessUser() {
		return createSuccessUser;
	}



	public DataStore<CreateFailUser> getCreateFailUser() {
		return createFailUser;
	}



	public DataStore<CreateRequestResource> getCreateRequestResource() {
		return createRequestResource;
	}



	public DataStore<CreateSuccessResource> getCreateSuccessResource() {
		return createSuccessResource;
	}



	public DataStore<CreateFailResource> getCreateFailResource() {
		return createFailResource;
	}



	public DataStore<CreateRequestGroup> getCreateRequestGroup() {
		return createRequestGroup;
	}



	public DataStore<CreateSuccessGroup> getCreateSuccessGroup() {
		return createSuccessGroup;
	}



	public DataStore<CreateFailGroup> getCreateFailGroup() {
		return createFailGroup;
	}



	public DataStore<DeleteRequestCollection> getDeleteRequestCollection() {
		return deleteRequestCollection;
	}



	public DataStore<DeleteSuccessCollection> getDeleteSuccessCollection() {
		return deleteSuccessCollection;
	}



	public DataStore<DeleteFailCollection> getDeleteFailCollection() {
		return deleteFailCollection;
	}



	public DataStore<DeleteRequestUser> getDeleteRequestUser() {
		return deleteRequestUser;
	}



	public DataStore<DeleteSuccessUser> getDeleteSuccessUser() {
		return deleteSuccessUser;
	}



	public DataStore<DeleteFailUser> getDeleteFailUser() {
		return deleteFailUser;
	}



	public DataStore<DeleteRequestResource> getDeleteRequestResource() {
		return deleteRequestResource;
	}



	public DataStore<DeleteSuccessResource> getDeleteSuccessResource() {
		return deleteSuccessResource;
	}



	public DataStore<DeleteFailResource> getDeleteFailResource() {
		return deleteFailResource;
	}



	public DataStore<DeleteRequestGroup> getDeleteRequestGroup() {
		return deleteRequestGroup;
	}



	public DataStore<DeleteSuccessGroup> getDeleteSuccessGroup() {
		return deleteSuccessGroup;
	}



	public DataStore<DeleteFailGroup> getDeleteFailGroup() {
		return deleteFailGroup;
	}



	public DataStore<UpdateRequestCollection> getUpdateRequestCollection() {
		return updateRequestCollection;
	}



	public DataStore<UpdateSuccessCollection> getUpdateSuccessCollection() {
		return updateSuccessCollection;
	}



	public DataStore<UpdateFailCollection> getUpdateFailCollection() {
		return updateFailCollection;
	}



	public DataStore<UpdateRequestUser> getUpdateRequestUser() {
		return updateRequestUser;
	}



	public DataStore<UpdateSuccessUser> getUpdateSuccessUser() {
		return updateSuccessUser;
	}



	public DataStore<UpdateFailUser> getUpdateFailUser() {
		return updateFailUser;
	}



	public DataStore<UpdateRequestResource> getUpdateRequestResource() {
		return updateRequestResource;
	}



	public DataStore<UpdateSuccessResource> getUpdateSuccessResource() {
		return updateSuccessResource;
	}



	public DataStore<UpdateFailResource> getUpdateFailResource() {
		return updateFailResource;
	}



	public DataStore<UpdateRequestGroup> getUpdateRequestGroup() {
		return updateRequestGroup;
	}



	public DataStore<UpdateSuccessGroup> getUpdateSuccessGroup() {
		return updateSuccessGroup;
	}



	public DataStore<UpdateFailGroup> getUpdateFailGroup() {
		return updateFailGroup;
	}



	public Set<String> getControlSet() {
        return controlSet;
    }

	
}
