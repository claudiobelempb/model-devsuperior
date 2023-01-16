import { css } from 'styled-components';
import { TypeThemeNumberDefault } from '../ThemeType';

type TypePaddingDefault = {
  static?: TypeThemeNumberDefault;
  dynamic?: TypeThemeNumberDefault;
  unit?: 'px' | '%' | 'rem' | 'vw' | 'vh';
};

export type TypePaddingDefaultProps = {
  paddingStaticDefault?: TypePaddingDefault;
  paddingTopStaticDefault?: TypePaddingDefault;
  paddingRightStaticDefault?: TypePaddingDefault;
  paddingLeftStaticDefault?: TypePaddingDefault;
  paddingBottomStaticDefault?: TypePaddingDefault;
  paddingXStaticDefault?: TypePaddingDefault;
  paddingYStaticDefault?: TypePaddingDefault;
  paddingDynamicDefault?: TypePaddingDefault;
};

export const paddingDefault = {
  paddingDefault: ({
    paddingStaticDefault,
    paddingDynamicDefault,
    paddingBottomStaticDefault,
    paddingLeftStaticDefault,
    paddingRightStaticDefault,
    paddingTopStaticDefault,
    paddingXStaticDefault,
    paddingYStaticDefault,
  }: TypePaddingDefaultProps) => css`
    ${
      paddingStaticDefault &&
      css`
      padding: calc(10 * ${paddingStaticDefault.static}${paddingStaticDefault.unit}) calc(10 * ${paddingStaticDefault.static}${paddingStaticDefault.unit});
    `
    };
    ${
      paddingTopStaticDefault &&
      css`
      padding-top: calc(10 * ${paddingTopStaticDefault.static}${paddingTopStaticDefault.unit});
    `
    };
    ${
      paddingRightStaticDefault &&
      css`
      padding-right: calc(10 * ${paddingRightStaticDefault.static}${paddingRightStaticDefault.unit});
    `
    };
    ${
      paddingLeftStaticDefault &&
      css`
      padding-left: calc(10 * ${paddingLeftStaticDefault.static}${paddingLeftStaticDefault.unit});
    `
    };
    ${
      paddingBottomStaticDefault &&
      css`
      padding-bottom: calc(10 * ${paddingBottomStaticDefault.static}${paddingBottomStaticDefault.unit});
    `
    };
    ${
      paddingXStaticDefault &&
      css`
      padding-right: calc(10 * ${paddingXStaticDefault.static}${paddingXStaticDefault.unit});
      padding-left: calc(10 * ${paddingXStaticDefault.static}${paddingXStaticDefault.unit});
    `
    };
    ${
      paddingYStaticDefault &&
      css`
      padding-top: calc(10 * ${paddingYStaticDefault.static}${paddingYStaticDefault.unit});
      padding-bottom: calc(10 * ${paddingYStaticDefault.static}${paddingYStaticDefault.unit});
    `
    };
    ${
      paddingDynamicDefault &&
      css`
      padding: calc(10 * ${paddingDynamicDefault.static}rem + ${paddingDynamicDefault.dynamic}${paddingDynamicDefault.unit});
    `
    };
  `,
};
