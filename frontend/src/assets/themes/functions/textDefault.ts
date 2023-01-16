import { css } from 'styled-components';
import { TypeThemeNumberDefault } from '../ThemeType';

export type TypeTextDefault = {
  textLineThrough?: 'line-through';
  textTransform?: TypeTextTransform;
  textAlign?: TypeTetxAlign;
  unit?: 'px' | '%' | 'rem' | 'vw' | 'vh';
  value?: TypeThemeNumberDefault;
  dynamic?: TypeThemeNumberDefault;
};

export type TypeTextTransform =
  | 'none'
  | 'capitalize'
  | 'uppercase'
  | 'lowercase'
  | 'full-width'
  | 'unset'
  | 'inherit'
  | 'none'
  | 'full-size-kana';

export type TypeTetxAlign =
  | 'start'
  | 'end'
  | 'left'
  | 'right'
  | 'center'
  | 'justify'
  | 'justify-all'
  | 'match-parent';

export const textDefault = {
  text: ({ textTransform, textAlign, textLineThrough }: TypeTextDefault) => css`
    ${
      textTransform &&
      css`
      text-transform: ${textTransform};
    `
    };
    ${
      textAlign &&
      css`
      text-align: ${textAlign};
    `
    };
    ${
      textLineThrough &&
      css`
    text-decoration: ${textLineThrough};
    `
    }

  `,
};
