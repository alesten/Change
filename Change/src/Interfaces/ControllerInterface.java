/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.List;

/**
 *
 * @author alexandersteen
 */
public interface ControllerInterface {
    List<CountryInterface> getCountries();
    boolean fly(CountryInterface country);
    PlayerInterface getPlayer();
    boolean vistHospital(PlayerInterface player);
}
