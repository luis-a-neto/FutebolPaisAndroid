package br.com.futeboldospais.futeboldospais.util;

/**
 * Copied by Daniel Almeida on 08/09/2017.
 */

import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;

import java.lang.reflect.Field;

/**
 * Classe para desabilitar o modo de movimento de itens do menu BottomNavigation
 */
public class BottomNavigationViewHelper {

    /**
     * Copied by Daniel Almeida on 08/09/2017.
     * Recebe um BottomNavigationView como paramêtro
     * Cria um objeto Field para usar a reflexão
     * Conta todos o item no menu e desativa o movimento deles
     * @param view
     */
    public static void disableShiftMode(BottomNavigationView view) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                //Desativa o movimento de items
                item.setShiftingMode(false);
                //Deixa os itens em modo checado, que faz com que o texto apareça
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e) {
            Log.e("BNVHelper", "Unable to get shift mode field", e);
        } catch (IllegalAccessException e) {
            Log.e("BNVHelper", "Unable to change value of shift mode", e);
        }
    }
}
