import { css } from 'styled-components';
import { TypeThemeNumberDefault } from '../ThemeType';

type TypeMarginDefault = {
  static?: TypeThemeNumberDefault;
  dynamic?: TypeThemeNumberDefault;
  unit?: 'px' | '%' | 'rem' | 'vw' | 'vh';
};

export type TypeMarginDefaultProps = {
  marginStaticDefault?: TypeMarginDefault;
  marginTopStaticDefault?: TypeMarginDefault;
  marginRightStaticDefault?: TypeMarginDefault;
  marginLeftStaticDefault?: TypeMarginDefault;
  marginBottomStaticDefault?: TypeMarginDefault;
  marginXStaticDefault?: TypeMarginDefault;
  marginYStaticDefault?: TypeMarginDefault;
  marginDynamicDefault?: TypeMarginDefault;
};

export const marginDefault = {
  marginDefault: ({
    marginStaticDefault,
    marginDynamicDefault,
    marginBottomStaticDefault,
    marginLeftStaticDefault,
    marginRightStaticDefault,
    marginTopStaticDefault,
    marginXStaticDefault,
    marginYStaticDefault,
  }: TypeMarginDefaultProps) => css`
    ${
      marginStaticDefault &&
      css`
      margin: calc(10 * ${marginStaticDefault.static}${marginStaticDefault.unit});
    `
    };
    ${
      marginTopStaticDefault &&
      css`
      margin-top: calc(10 * ${marginTopStaticDefault.static}${marginTopStaticDefault.unit});
    `
    };
    ${
      marginRightStaticDefault &&
      css`
      margin-right: calc(10 * ${marginRightStaticDefault.static}${marginRightStaticDefault.unit});
    `
    };
    ${
      marginLeftStaticDefault &&
      css`
      margin-left: calc(10 * ${marginLeftStaticDefault.static}${marginLeftStaticDefault.unit});
    `
    };
    ${
      marginBottomStaticDefault &&
      css`
      margin-bottom: calc(10 * ${marginBottomStaticDefault.static}${marginBottomStaticDefault.unit});
    `
    };
    ${
      marginXStaticDefault &&
      css`
      margin-right: calc(10 * ${marginXStaticDefault.static}${marginXStaticDefault.unit});
      margin-left: calc(10 * ${marginXStaticDefault.static}${marginXStaticDefault.unit});
    `
    };
    ${
      marginYStaticDefault &&
      css`
      margin-top: calc(10 * ${marginYStaticDefault.static}${marginYStaticDefault.unit});
      margin-bottom: calc(10 * ${marginYStaticDefault.static}${marginYStaticDefault.unit});
    `
    };
    ${
      marginDynamicDefault &&
      css`
      margin: calc(10 * ${marginDynamicDefault.static}rem + ${marginDynamicDefault.dynamic}vw);
    `
    };
  `,
};
