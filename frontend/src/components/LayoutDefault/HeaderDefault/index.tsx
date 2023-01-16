import React from 'react';
import { FaGithub } from 'react-icons/fa';
import { TypeDefault } from '../../../assets/themes/TypeDefault';
import { BoxDefault } from '../../common/BoxDefault';
import { BrandDefault } from '../../common/BrandDefault';
import { ContainerDefault } from '../../common/ContainerDefault';
import { ContentDefault } from '../../common/ContentDefault';
import { LinkDefault } from '../../common/LinkDefault';

const HeaderDefault: React.FC<TypeDefault> = ({ ...props }) => {
  return (
    <ContainerDefault
      colorDefault={{
        backgroundColorDefalut: { index: 'primary', value: 'v500' },
      }}
      as="header"
    >
      <ContentDefault
        heightDefault={{ minHeightDefault: { value: 0.6, unit: 'rem' } }}
        flexDefault={{
          flexDefault: 'flex',
          flexDirectionDefault: 'row',
          flexJustifyContentDefault: 'space-between',
          flexAlignItemsDefault: 'center',
        }}
      >
        <BoxDefault>
          {props.children}
          <BrandDefault variantType="title" title="DSMovie" />
        </BoxDefault>
        <BoxDefault
          flexDefault={{
            flexDefault: 'flex',
            flexAlignItemsDefault: 'center',
            flexJustifyContentDefault: 'flex-end',
            flexGapDefault: { column: 1, row: 2, unit: 'rem' },
          }}
        >
          <LinkDefault
            flexDefault={{
              flexDefault: 'flex',
              flexAlignItemsDefault: 'center',
              flexJustifyContentDefault: 'flex-end',
              flexGapDefault: { column: 0.05, row: 0.2, unit: 'rem' },
            }}
            colorDefault={{
              colorDefalut: { index: 'default', value: 'white' },
            }}
          >
            <FaGithub size={24} />
            /claudiobelempb
          </LinkDefault>
        </BoxDefault>
      </ContentDefault>
    </ContainerDefault>
  );
};

export { HeaderDefault };
