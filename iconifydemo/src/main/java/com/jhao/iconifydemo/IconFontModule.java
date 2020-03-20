package com.jhao.iconifydemo;

import com.joanzapata.iconify.Icon;
import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.fonts.FontAwesomeIcons;

/**
 * @author JiangHao
 * @date 2020/3/20
 * @describe
 */
public class IconFontModule implements IconFontDescriptor {
    @Override
    public String ttfFileName() {
        return "iconfont.ttf";
    }

    @Override
    public Icon[] characters() {
        return IconFonts.values();
    }
}
