/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 * Copyright (C) 2006-2010 Adele Team/LIG/Grenoble University, France
 */
package fr.imag.adele.fede.workspace.as.persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.NoSuchAlgorithmException;

import fr.imag.adele.cadse.core.CadseException;
import fr.imag.adele.cadse.core.CadseRuntime;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import fr.imag.adele.cadse.core.Item;
import fr.imag.adele.cadse.core.ItemDescription;
import fr.imag.adele.cadse.core.LogicalWorkspace;
import java.util.List;
import fr.imag.adele.cadse.core.transaction.delta.ItemDelta;
import fr.imag.adele.cadse.core.transaction.LogicalWorkspaceTransaction;

/**
 * 
 */
public interface IPersistence {

    /**
     * Exist persistance.
     *
     * @return true, if successful
     */
    boolean existPersistence();

    /**
     * Save.
     */
    void saveAll();

    /**
     * Delete.
     */
    void deleteAll();

	/**
	 * Load.
	 * 
	 * @return true, if successful
	 */
	boolean load();

	/**
	 * Load.
	 * 
	 * @param location
	 *            the location
	 * 
	 * @return true, if successful
	 */
	boolean load(String location);

	/**
	 * Save.
	 */
	void save();
    public String[] getRunningCadsesName();

    /**
     * Gets the cadses version.
     *
     * @return the cadses version
     */
    public int[] getRunningCadsesVersion();
	
	// void save(Item item) throws Throwable;

	/**
	 * Delete.
	 */
	void delete();

    public CadseRuntime[] getRunningCadses( );
    /**
     * Save.
     *
     * @param item
     *            the item
     * @param repository
     *            the repository
     * Load.
     *
     * @param wl
     *            the wl
     * @param directory
     *            the directory
     * @param failthrow
     *            the failthrow
     *
     * @return the item description[]
     *
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     * @throws CadseException
     *             the melusine exception
     */
    public Item[] load(LogicalWorkspace wl, boolean failthrow) throws CadseException;

    /**
     * Save.
     *
     * @param item
     *            the item
     * @param repository
     *            the repository
    public void saveSer(Item item, File fileSer) throws CadseException;
	/**
	 * New method use the workspace notification to save.
	 * 
	 * @return the cadses name
	 * 
	 * @throws Throwable
	 */
	// public void notifieChangeEvent(ChangeID id, Object... values );
	public String[] getCadsesName();

	/**
	 * Gets the cadses version.
	 * 
	 * @return the cadses version
	 */
	public int[] getCadsesVersion();

     /**
     * Load from persistence.
     *
     * @param wl
     *            the wl
     * @param url
     *            the url
     *
     * @return the item description
     *
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     * @throws CadseException
     *             the melusine exception
     */
    public void saveSer(Item item, File fileSer) throws CadseException;


     /**
     * Load from persistence.
     *
     * @param wl
     *            the wl
     * @param url
     *            the url
     *
     * @return the item description
     *
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     * @throws CadseException
     *             the melusine exception
     */
    public Item[] loadFromPersistence(LogicalWorkspace lw, List<URL> url) throws CadseException;

	/**
	 * Read orphan repository.
	 * 
	 * @param wl
	 *            the wl
	 * @param repository
	 *            the repository
	 * 
	 * @return the item[]
	 */
	public Item[] readOrphanRepository(LogicalWorkspace wl, File repository);

	/**
	 * Start listener.
	 */
	public void startListener();

	/**
	 * Sets the modelname.
	 * 
	 * @param wsModel
	 *            the ws model
	 * @param versions
	 *            the versions
	 */
	@Deprecated
	void setModelname(String[] wsModel, int[] versions);

	/**
	 * Force save.
	 */
	void forceSave();

	/**
	 * Load from persistence.
	 * 
	 * @param wl
	 *            the wl
	 * @param url
	 *            the url
	 * 
	 * @return the item description
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws CadseException
	 *             the melusine exception
	 */
	public ItemDelta[] loadFromPersistence(LogicalWorkspaceTransaction transaction, Map<UUID, URL> url) throws CadseException;

	/**
	 * Load from persistence.
	 * 
	 * @param wl
	 *            the wl
	 * @param url
	 *            the url
	 * 
	 * @return the item description
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws CadseException
	 *             the melusine exception
	 * @throws CadseException
	 */
	public ItemDelta loadFromPersistence(LogicalWorkspaceTransaction wl, InputStream stream) throws CadseException;

	/**
	 * Load.
	 * 
	 * @param wl
	 *            the wl
	 * @param directory
	 *            the directory
	 * @param failthrow
	 *            the failthrow
	 * 
	 * @return the item description[]
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws CadseException
	 *             the melusine exception
	 */
	public ItemDelta[] load(LogicalWorkspace wl, File directory, boolean failthrow) throws IOException,
			CadseException;

	/**
	 * Save.
	 * 
	 * @param item
	 *            the item
	 * @param repository
	 *            the repository
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws CadseException
	 *             the melusine exception
	 */
	public void save(Item item, File repository) throws IOException, CadseException;

	File getLocationSer(UUID id);

	File getLocation();

	public void setLocation(File location);

	void save(Item[] items) throws FileNotFoundException, NoSuchAlgorithmException, IOException;


}
