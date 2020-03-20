package com.jhao.iconifydemo;

import com.joanzapata.iconify.Icon;
import com.joanzapata.iconify.fonts.IoniconsIcons;

/**
 * @author JiangHao
 * @date 2020/3/20
 * @describe
 */
public enum IconFonts implements Icon {
    //&#xe61e 将/&#x替换成\\u
    weixinzhifu('\ue61e'),
    zhifubao1('\ue60a'),
    zhifubao2('\ue637'),
    maerdaifu('\ue653'),
    Brooklyn('\ue654');


    char character;

    IconFonts(char charcter) {
        this.character = charcter;
    }

    @Override
    public String key() {
        return name().replace('_', '-');
    }

    @Override
    public char character() {
        return character;
    }
}
