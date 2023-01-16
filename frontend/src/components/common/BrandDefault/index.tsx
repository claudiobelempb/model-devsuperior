import React from 'react';
import { Link } from 'react-router-dom';
import BrandImg from '../../../assets/images/logo.svg';
import { TypeDefault } from '../../../assets/themes/TypeDefault';
import { HeadingDefault } from '../HeadingDefault';
import { ImgDefault } from '../ImgDefault';

type BrandDefaultType = {
  variantType: 'title' | 'img';
  title?: string;
};

type BrandDefaultProps = TypeDefault & BrandDefaultType;

const BrandDefault: React.FC<BrandDefaultProps> = ({ ...props }) => {
  switch (props.variantType) {
    case 'title':
      return (
        <HeadingDefault
          as="h1"
          {...props}
          variant={{ colorDefalut: { index: 'default', value: 'white' } }}
          fontDefault={{
            fontSizeStatic: { static: 0.24, unit: 'rem' },
            fontWeigh: '700',
          }}
          textDefault={{ textTransform: 'unset' }}
          colorDefault={{ colorDefalut: { index: 'default', value: 'white' } }}
        >
          <Link to={props.url ? props.url : '/'}>{props.title}</Link>
        </HeadingDefault>
      );

    default:
      return (
        <HeadingDefault {...props} as="h1">
          <Link to={props.url ? props.url : '/'}>
            {props.children}
            <ImgDefault src={BrandImg} width={20} alt="Git Collection" />
          </Link>
        </HeadingDefault>
      );
  }
};

export { BrandDefault };
