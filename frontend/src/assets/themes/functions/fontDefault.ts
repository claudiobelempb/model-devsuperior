import { css } from 'styled-components';
import { TypeThemeNumberDefault } from '../ThemeType';
import { TypeVariant } from './colorDefault';

export type TypeFontDefault = {
  variant?: TypeVariant;
  unit?: 'px' | '%' | 'rem' | 'vw' | 'vh';
  value?: TypeThemeNumberDefault;
  dynamic?: TypeThemeNumberDefault;
  fontFamily?: TypeFontFamily;
  fontStyle?: TypeFontStyle;
  fontLineHeight?: TypeFontLineHeight;
  fontWeigh?: TypeFontWeigh;
  fontSizeStatic?: TypeFontSizeStatic;
  fontSizeIcon?: TypeFontSizeStatic;
  fontSizeDynamic?: TypeFontSizeDynamic;
};

type TypeFontSizeStatic = {
  variant?: TypeVariant;
  unit?: 'px' | '%' | 'rem' | 'vw' | 'vh';
  static?: TypeThemeNumberDefault;
  dynamic?: TypeThemeNumberDefault;
};

type TypeFontSizeDynamic = {
  variant?: TypeVariant;
  unit?: 'px' | '%' | 'rem' | 'vw' | 'vh';
  static?: TypeThemeNumberDefault;
  dynamic?: TypeThemeNumberDefault;
};

export type TypeFontFamily =
  | 'Roboto'
  | 'Roboto Mono'
  | 'baloo'
  | 'oswald'
  | 'plusJakarta';

export type TypeFontStyle =
  | 'normal'
  | 'italic'
  | 'oblique'
  | 'initial'
  | 'inherit';

export type TypeFontLineHeight = '65%' | '130%' | '160%';

export type TypeFontWeigh =
  | '100'
  | '200'
  | '300'
  | '400'
  | '500'
  | '600'
  | '700'
  | '800'
  | '900'
  | 'bold'
  | 'extraBold';

export const fontDefault = {
  fontDefault: ({
    fontFamily,
    fontSizeStatic,
    fontSizeDynamic,
    fontStyle,
    fontLineHeight,
    fontWeigh,
    fontSizeIcon,
  }: TypeFontDefault) => css`
    ${
      fontFamily &&
      css`
      font-family: ${fontFamily};
    `
    };
    ${
      fontSizeStatic?.static &&
      css`
      font-size: calc(10 * ${fontSizeStatic.static}${fontSizeStatic.unit});
    `
    };
    ${
      fontSizeIcon?.static &&
      css`
      font-size: calc(10 * ${fontSizeIcon.static}${fontSizeIcon.unit});
    `
    };
    ${
      fontSizeDynamic?.static &&
      css`
      font-size: calc(10 * ${fontSizeDynamic.dynamic}${fontSizeDynamic.unit});
    `
    };
     ${
       fontStyle &&
       css`
      font-style: ${fontStyle};
    `
     };
     ${
       fontLineHeight &&
       css`
      line-height: ${fontLineHeight};
    `
     };
     ${
       fontWeigh &&
       css`
      font-weight: ${fontWeigh};
    `
     };
  `,
};
