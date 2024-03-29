function [Y, ctrPre1, ctrPre2, ctrInt, ctrPost1, ctrPost2] = dct2d( X )

% CONSTANT DECLARATION
N=8;
pi = 3.141596;
dyn = 12; % bits per coefficient

% XIT OF THE COEFFICIENT ARRAY
ref = sqrt(2/N);
for i=1:N - 1
   C(i)= Qn(ref  *  cos(i * pi/16), dyn);
end

for ii = 1:8
	for jj = 1:8
		ctrPre1(ii, jj) = assert( X(ii,jj) > 0);
		ctrPre2(ii, jj) = assert( X(ii,jj) < 2147483640);
	end
end

% THE COMPUTATION CORE
for y =1:8
  T(y,0 + 1) = C(4) * (X(y,1) + X(y,2)  +        (X(y,3) + X(y,4)) +        (X(y,5) + X(y,6)) +        (X(y,7) + X(y,8)));
  T(y,2 + 1) = C(2) * (X(y,1) + X(y,8)) + C(6) * (X(y,2) + X(y,7)) - C(6) * (X(y,3) + X(y,6)) - C(2) * (X(y,4) + X(y,5));
  T(y,4 + 1) = C(4) * (X(y,1) + X(y,8)) - C(4) * (X(y,2) + X(y,7)) - C(4) * (X(y,3) + X(y,6)) + C(4) * (X(y,4) + X(y,5));
  T(y,6 + 1) = C(6) * (X(y,1) + X(y,8)) - C(2) * (X(y,2) + X(y,7)) + C(2) * (X(y,3) + X(y,6)) - C(6) * (X(y,4) + X(y,5));

  T(y,1 + 1) = C(1) * (X(y,1) - X(y,8)) + C(3) * (X(y,2) - X(y,7)) + C(5) * (X(y,3) - X(y,6)) + C(7) * (X(y,4) - X(y,5));
  T(y,3 + 1) = C(3) * (X(y,1) - X(y,8)) - C(7) * (X(y,2) - X(y,7)) - C(1) * (X(y,3) - X(y,6)) - C(5) * (X(y,4) - X(y,5));
  T(y,5 + 1) = C(5) * (X(y,1) - X(y,8)) - C(1) * (X(y,2) - X(y,7)) + C(7) * (X(y,3) - X(y,6)) + C(3) * (X(y,4) - X(y,5));
  T(y,7 + 1) = C(7) * (X(y,1) - X(y,8)) - C(5) * (X(y,2) - X(y,7)) + C(3) * (X(y,3) - X(y,6)) - C(1) * (X(y,4) - X(y,5));
end


for ii = 1:8
	for jj = 1:8
		ctrInt(ii, jj) = assert (T(ii, jj) > -2147483640);
	end
end

for x =1:8
	Y(0 + 1,x) = C(4) * (T(1,x) + T(2,x) + T(3,x) + T(4,x) + T(5,x) + T(6,x) + T(7,x) + T(8,x));
	Y(2 + 1,x) = C(2) * (T(1,x) + T(8,x)) + C(6) * (T(2,x) + T(7,x)) - C(6) * (T(3,x) + T(6,x)) - C(2) * (T(4,x) + T(5,x));
	Y(4 + 1,x) = C(4) * (T(1,x) + T(8,x)) - C(4) * (T(2,x) + T(7,x)) - C(4) * (T(3,x) + T(6,x)) + C(4) * (T(4,x) + T(5,x));
	Y(6 + 1,x) = C(6) * (T(1,x) + T(8,x)) - C(2) * (T(2,x) + T(7,x)) + C(2) * (T(3,x) + T(6,x)) - C(6) * (T(4,x) + T(5,x));

	Y(1 + 1,x) = C(1) * (T(1,x) - T(8,x)) + C(3) * (T(2,x) - T(7,x)) + C(5) * (T(3,x) - T(6,x)) + C(7) * (T(4,x) - T(5,x));
	Y(3 + 1,x) = C(3) * (T(1,x) - T(8,x)) - C(7) * (T(2,x) - T(7,x)) - C(1) * (T(3,x) - T(6,x)) - C(5) * (T(4,x) - T(5,x));
	Y(5 + 1,x) = C(5) * (T(1,x) - T(8,x)) - C(1) * (T(2,x) - T(7,x)) + C(7) * (T(3,x) - T(6,x)) + C(3) * (T(4,x) - T(5,x));
	Y(7 + 1,x) = C(7) * (T(1,x) - T(8,x)) - C(5) * (T(2,x) - T(7,x)) + C(3) * (T(3,x) - T(6,x)) - C(1) * (T(4,x) - T(5,x));
end

for ii = 1:8
	for jj = 1:8
		ctrPost1(ii, jj) = assert( Y(ii,jj) > -2147483640);
		ctrPost2(ii, jj) = assert( Y(ii,jj) < 2147483640);
	end
end
