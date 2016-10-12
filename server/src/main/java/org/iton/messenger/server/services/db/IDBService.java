/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.iton.messenger.server.services.db;


import org.iton.messenger.model.engines.ITelegramEngine;

/**
 *
 * @author ITON
 */
public interface IDBService {

    ITelegramEngine getEngine();
}
