import styled, { css } from 'styled-components';
import { afterDefault } from '../../assets/themes/functions/afterDefault';
import { beforeDefault } from '../../assets/themes/functions/beforeDefault';
import {
  borderDefault,
  borderRadiusDefault,
} from '../../assets/themes/functions/borderDefault';
import { colorDefault } from '../../assets/themes/functions/colorDefault';
import { effectDefault } from '../../assets/themes/functions/effectDefaults';
import { flexDefault } from '../../assets/themes/functions/flexDefault';
import { fontDefault } from '../../assets/themes/functions/fontDefault';
import { gridDefault } from '../../assets/themes/functions/gridDefault';
import { heightDefault } from '../../assets/themes/functions/heightDefault';
import { marginDefault } from '../../assets/themes/functions/marginDefault';
import { paddingDefault } from '../../assets/themes/functions/paddingDefault';
import { positionDefault } from '../../assets/themes/functions/positionDefault';
import { textDefault } from '../../assets/themes/functions/textDefault';
import { utilsDefault } from '../../assets/themes/functions/utilsDefault';
import { widthDefault } from '../../assets/themes/functions/widthDefault';
import { TypeDefault } from '../../assets/themes/TypeDefault';

export const CardContainerDefaultStyle = styled.div<TypeDefault>`
  ${({ theme, ...props }) => css`
    /* z-index: -30; */
    /* height: 100%; */
    position: relative;
    width: 100%;
    /* display: flex; */
    ${props.gridDefault && gridDefault.gridDefault({})}
    ${
      props.colorDefault
        ? colorDefault.colorDefault(props.colorDefault)
        : theme.colorDefault({
            borderColorDefalut: { color: { index: 'blue', value: 'v500' } },
            backgroundColorDefalut: { index: 'red', value: 'v500' },
            colorDefalut: { index: 'default', value: 'white' },
          })
    };

     /*TEXT DEFAULT */
     ${
       props.textDefault
         ? textDefault.text(props.textDefault)
         : theme.textDefault({ textAlign: 'center' })
     }
    /*FONT DEFAULT  */
    ${
      props.fontDefault
        ? fontDefault.fontDefault(props.fontDefault)
        : theme.fontDefault({})
    }
    /*ICON DEFAULT */
    ${props.iconDefault && props.iconDefault()};

    /* Padding Default */
    ${
      props.paddingDefault
        ? paddingDefault.paddingDefault(props.paddingDefault)
        : theme.paddingDefault({
            paddingYStaticDefault: { static: 0.1, unit: 'rem' },
          })
    };
    /* Margin Default */
    ${
      props.marginDefault
        ? marginDefault.marginDefault(props.marginDefault)
        : theme.marginDefault({})
    };
    /*UTILS DEFAULT */
    ${
      props.ultilsDefault
        ? utilsDefault.utilsDefault(props.ultilsDefault)
        : theme.utilsDefault({})
    }

    /*BORDER DEFAULT */
    ${props.borderDefault && borderDefault.borderDefault(props.borderDefault)}
    /*BORDER RADIUS DEFAULT */
    ${
      props.borderRadiusDefault
        ? borderRadiusDefault.borderRadiusDefault(props.borderRadiusDefault)
        : theme.borderRadiusDefault.borderRadiusDefault({
            borderRadiusDefault: {
              width: 0.5,
              unit: 'rem',
              colorDefault: {
                borderColorDefalut: {
                  color: { index: 'red', value: 'v500' },
                },
              },
            },
          })
    };

    /*HEIGHT DEFAULT  */
    ${props.heightDefault && heightDefault.heightDefault(props.heightDefault)}
    /*WIDTH DEFAULT  */
    ${props.widthDefault && widthDefault.widthDefault(props.widthDefault)}

    /*EFFECT DEFAULT */
    ${props.effectDefault && effectDefault.effectDefault({})}
    /*BEFORE DEFAULT  */
    ${props.beforeDefault && beforeDefault({})};
    /*BEFORE DEFAULT  */
    ${props.afterDefault && afterDefault({})};
    /*POSITION DEFAULT  */
    ${props.positionDefault && positionDefault({})};

    /* GRID DEFAULT */
    ${props.gridTemplateColumnsDefault && props.gridTemplateColumnsDefault()}
    ${
      props.gridTemplateColumnsStaticDefault &&
      props.gridTemplateColumnsStaticDefault()
    }
    ${props.gridTemplateRowsDefault && props.gridTemplateRowsDefault()}
    ${props.gridColumnDefault && props.gridColumnDefault()}
    ${props.gridRowDefault && props.gridRowDefault()}

    /* FLEX DEFAULT */
    ${
      props.flexDefault
        ? flexDefault.flexDefault(props.flexDefault)
        : theme.flexDefault({})
    }

    // sm applies to x-small devices (portrait phones, less than 576px)
    @media (max-width: 320px) {

    }

    // md applies to small devices (landscape phones, less than 768px)
    @media (min-width: 320px) and (max-width: 576px) {

    }

    // lg applies to medium devices (tablets, less than 992px)
    @media (min-width: 576px) and (max-width: 768px) {

    }

    // xl applies to large devices (desktops, less than 1200px)
    @media (min-width: 768px) and (max-width: 992px) {

    }

    // xxl applies to x-large devices (large desktops, less than 1400px)
    @media (min-width: 992px) and (max-width: 1200px) {

    }
    // xxl applies to x-large devices (large desktops, less than 1400px)
    @media (min-width: 1200px) and (max-width: 1400px) {

    }
  `}
`;
