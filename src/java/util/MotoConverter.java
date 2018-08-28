/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.Dao;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import modelo.Motocicleta;

@FacesConverter(value = "MotoConverter")
public class MotoConverter implements Converter{
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        String nome;
        Motocicleta temp = null;
        Dao<Motocicleta> dao = new Dao(Motocicleta.class);
        try {
            nome = value;
            temp = dao.buscarPorPlacaMotocicleta(nome);
	} catch (Exception e) {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro","Selecione uma moto"));
	}
 	return temp;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
        if (obj instanceof Motocicleta){
            Motocicleta v = (Motocicleta)obj;
            return v.getPlaca();
        }
        return "";
    }
}
