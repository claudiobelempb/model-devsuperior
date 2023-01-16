import { FaStar } from 'react-icons/fa';
import CardImg from '../../assets/images/dsmovie/card-img.svg';
import { TypeDefault } from '../../assets/themes/TypeDefault';
import { BoxDefault } from '../common/BoxDefault';
import { HeadingDefault } from '../common/HeadingDefault';
import { ImgDefault } from '../common/ImgDefault';
import { LinkDefault } from '../common/LinkDefault';
import { TextDefault } from '../common/TextDefault';

type CardDefaultType = {
  src?: string;
  title?: string;
};

type CardDefaultProps = CardDefaultType & TypeDefault;

const CardDefault: React.FC<CardDefaultProps> = ({ ...props }) => {
  return (
    <BoxDefault
      borderRadiusDefault={{ borderRadiusDefault: { width: 0.5, unit: 'rem' } }}
      colorDefault={{
        backgroundColorDefalut: { index: 'default', value: 'white' },
      }}
      as="article"
      heightDefault={{ maxHeightDefault: { value: 3.5, unit: 'rem' } }}
      widthDefault={{ maxWidthDefault: { value: 2.3, unit: 'rem' } }}
      flexDefault={{
        flexDefault: 'flex',
        flexDirectionDefault: 'column',
      }}
    >
      <ImgDefault
        borderRadiusDefault={{
          borderTopLeftRadiusDefault: { width: 0.5, unit: 'rem' },
          borderTopRightRadiusDefault: { width: 0.5, unit: 'rem' },
        }}
        src={props.src}
      />
      <HeadingDefault
        as="h2"
        colorDefault={{ colorDefalut: { index: 'dark', value: 'v500' } }}
        textDefault={{ textAlign: 'center' }}
        paddingDefault={{
          paddingTopStaticDefault: { static: 0.1, unit: 'rem' },
          paddingBottomStaticDefault: { static: 0.23, unit: 'rem' },
        }}
      >
        {props.title}
      </HeadingDefault>
      <TextDefault
        fontDefault={{ fontSizeStatic: { static: 0.16, unit: 'rem' } }}
        colorDefault={{ colorDefalut: { index: 'secondary', value: 'v500' } }}
        textDefault={{ textAlign: 'center' }}
      >
        3.8
      </TextDefault>
      <BoxDefault
        colorDefault={{ colorDefalut: { index: 'secondary', value: 'v500' } }}
        flexDefault={{
          flexDefault: 'flex',
          flexJustifyContentDefault: 'center',
        }}
      >
        <FaStar size={24} />
        <FaStar size={24} />
        <FaStar size={24} />
        <FaStar size={24} />
        <FaStar size={24} />
      </BoxDefault>
      <TextDefault
        colorDefault={{ colorDefalut: { index: 'light', value: 'v500' } }}
        fontDefault={{ fontSizeStatic: { static: 0.12, unit: 'rem' } }}
        textDefault={{ textAlign: 'center' }}
      >
        13 avaliações
      </TextDefault>
      <BoxDefault
        paddingDefault={{
          paddingTopStaticDefault: { static: 0.1, unit: 'rem' },
          paddingBottomStaticDefault: { static: 0.2, unit: 'rem' },
        }}
        flexDefault={{
          flexDefault: 'flex',
          flexJustifyContentDefault: 'center',
        }}
      >
        <LinkDefault
          href="/rating"
          borderRadiusDefault={{
            borderRadiusDefault: { width: 0.5, unit: 'rem' },
          }}
          paddingDefault={{
            paddingXStaticDefault: { static: 0.5, unit: 'rem' },
            paddingYStaticDefault: { static: 0.1, unit: 'rem' },
          }}
          colorDefault={{
            buttomColorDefalut: {
              background: { index: 'primary', value: 'v500' },
              color: { index: 'default', value: 'white' },
            },
          }}
        >
          Avaliar
        </LinkDefault>
      </BoxDefault>
    </BoxDefault>
  );
};

export { CardDefault };

CardDefault.defaultProps = {
  src: CardImg,
  title: 'O Espetacular Homem-Aranha 2: A Ameaça de Electro',
};
