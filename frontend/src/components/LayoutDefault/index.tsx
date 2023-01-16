import React from 'react';
import { TypeDefault } from '../../assets/themes/TypeDefault';
import { ContainerDefault } from '../common/ContainerDefault';
import { HeaderDefault } from './HeaderDefault';

const LayoutDefault: React.FC<TypeDefault> = ({ ...props }) => {
  return (
    <>
      <HeaderDefault />
      <ContainerDefault as="main">{props.children}</ContainerDefault>
    </>
  );
};

export { LayoutDefault };
