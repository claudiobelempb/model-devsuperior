import React from 'react';
import { FaChevronLeft, FaChevronRight } from 'react-icons/fa';
import { TypeDefault } from '../../assets/themes/TypeDefault';
import { BoxDefault } from '../common/BoxDefault';
import { ButtonDefault } from '../common/ButtonDefault';
import { ContentDefault } from '../common/ContentDefault';
import { TextDefault } from '../common/TextDefault';

const PaginationDefault: React.FC<TypeDefault> = ({ ...props }) => {
  return (
    <ContentDefault {...props}>
      <BoxDefault
        marginDefault={{ marginTopStaticDefault: { static: 0.2, unit: 'rem' } }}
        paddingDefault={{
          paddingYStaticDefault: { static: 0.01, unit: 'rem' },
        }}
        flexDefault={{
          flexDefault: 'flex',
          flexAlignItemsDefault: 'center',
          flexGapDefault: { column: 0.2, row: 0.1, unit: 'rem' },
          flexJustifyContentDefault: 'center',
        }}
      >
        <ButtonDefault
          disabled
          title=""
          colorDefault={{
            buttomColorDefalut: {
              background: { index: 'default', value: 'white' },
              color: { index: 'primary', value: 'v500' },
            },
          }}
          borderRadiusDefault={{
            borderRadiusDefault: { width: 0.5, unit: 'rem' },
          }}
          borderDefault={{
            borderDefault: {
              width: 0.2,
              unit: 'rem',
              style: 'solid',
              colorDefault: {
                colorDefalut: { index: 'primary', value: 'v500' },
              },
            },
          }}
        >
          <FaChevronLeft />
        </ButtonDefault>
        <TextDefault
          fontDefault={{
            fontSizeStatic: {
              static: 0.12,
              unit: 'rem',
            },
          }}
          colorDefault={{ colorDefalut: { index: 'primary', value: 'v500' } }}
        >
          1 de 23
        </TextDefault>
        <ButtonDefault
          title=""
          colorDefault={{
            buttomColorDefalut: {
              background: { index: 'default', value: 'white' },
              color: { index: 'primary', value: 'v500' },
            },
          }}
          borderRadiusDefault={{
            borderRadiusDefault: { width: 0.5, unit: 'rem' },
          }}
          borderDefault={{
            borderDefault: {
              width: 0.2,
              unit: 'rem',
              style: 'solid',
              colorDefault: {
                colorDefalut: { index: 'primary', value: 'v500' },
              },
            },
          }}
        >
          <FaChevronRight />
        </ButtonDefault>
      </BoxDefault>
    </ContentDefault>
  );
};

export { PaginationDefault };
